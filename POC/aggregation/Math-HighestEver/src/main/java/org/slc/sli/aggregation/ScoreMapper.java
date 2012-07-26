package org.slc.sli.aggregation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.bson.BSONObject;
import org.slc.sli.aggregation.mapreduce.TenantAndID;


/**
 * Maps a SAA to a double score
 */
public class ScoreMapper extends Mapper<String, BSONObject, TenantAndID, DoubleWritable> {

    public static final String SCORE_TYPE = "ScoreType";

    @Override
    protected void map(String id, BSONObject studentAssessment, Context context)
            throws IOException, InterruptedException {
        String type = context.getConfiguration().get(SCORE_TYPE);
        @SuppressWarnings("unchecked")
        Map<String, Object> body = (Map<String, Object>) studentAssessment.get("body");
        @SuppressWarnings("unchecked")
        List<Map<String, String>> results = (List<Map<String, String>>) body.get("scoreResults");
        String studentId = (String) body.get("studentId");
        @SuppressWarnings("unchecked")
        Map<String, Object> metaData = (Map<String, Object>) studentAssessment.get("metaData");
        String tenant = (String) metaData.get("tenantId");
                
        for (Map<String, String> result: results) {
            String scoreType = result.get("assessmentReportingMethod");
            if (type.equals(scoreType)) {
                String scoreString = result.get("result");
                double score = Double.parseDouble(scoreString);
                context.write(new TenantAndID(studentId, tenant), new DoubleWritable(score));
                return;
            }
        }
    }
    
}
