package org.slc.sli.ingestion.processors;

import java.util.Enumeration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;

import org.slc.sli.ingestion.BatchJob;
import org.slc.sli.ingestion.BatchJobLogger;
import org.slc.sli.ingestion.Fault;
import org.slc.sli.ingestion.FaultsReport;
import org.slc.sli.ingestion.landingzone.IngestionFileEntry;
import org.slc.sli.ingestion.landingzone.LandingZone;

/**
 * Transforms body from ControlFile to ControlFileDescriptor type.
 *
 * @author bsuzuki
 *
 */
public class JobReportingProcessor implements Processor {

    private LandingZone landingZone;

    public JobReportingProcessor(LandingZone lz) {
        this.landingZone = lz;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        // TODO get job from the batch job db
        BatchJob job = exchange.getIn().getBody(BatchJob.class);

        Logger jobLogger = BatchJobLogger.createLoggerForJob(job, landingZone);

        // add output as lines
        jobLogger.info("jobId: " + job.getId());

        for (IngestionFileEntry fileEntry : job.getFiles()) {
            String id = "[file] " + fileEntry.getFileName();
            jobLogger.info(id + " (" + fileEntry.getFileFormat()
                    + "/" + fileEntry.getFileType() + ")");
            Long numProcessed = exchange.getProperty(fileEntry.getFileName()
                    + ".records.processed", Long.class);
            if (numProcessed != null) {
                jobLogger.info(id + " records considered: "
                    + numProcessed);
            }

            Long numPassed = exchange.getProperty(fileEntry.getFileName()
                    + ".records.passed", Long.class);
            if (numProcessed != null) {
                jobLogger.info(id + " records ingested successfully: "
                    + numPassed);
            }

            Long numFailed = exchange.getProperty(fileEntry.getFileName()
                    + ".records.failed", Long.class);
            if (numProcessed != null) {
                jobLogger.info(id + " records failed: "
                    + numFailed);
            }
        }

        Enumeration<?> names = job.propertyNames();
        while (names.hasMoreElements()) {
            String key = (String) names.nextElement();
            jobLogger.info("[configProperty] " + key + ": "
                    + job.getProperty(key));
        }

        FaultsReport fr = job.getFaultsReport();

        for (Fault fault : fr.getFaults()) {
            if (fault.isError()) {
                jobLogger.error(fault.getMessage());
            } else {
                jobLogger.warn(fault.getMessage());
            }
        }

        if (fr.hasErrors()) {
            jobLogger.info("Not all records were processed completely due to errors.");
        } else {
            jobLogger.info("All records processed successfully.");
        }

        // This header is set in PersistenceProcessor
        if (exchange.getProperty("records.processed") != null) {
            jobLogger.info("Processed " + exchange.getProperty("records.processed") + " records.");
        }

        // clean up after ourselves
        ((ch.qos.logback.classic.Logger) jobLogger).detachAndStopAllAppenders();
        
    }

}
