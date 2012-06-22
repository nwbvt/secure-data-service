=begin

Copyright 2012 Shared Learning Collaborative, LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

=end


require 'selenium-webdriver'

Then /^the fuel gauge label for the assessment "([^"]*)" and student "([^"]*)" is "([^"]*)"$/ do |arg1, arg2, arg3|

  id = arg1 + "." + arg2 + ".label"
  element = @driver.find_element(:id, id)
  label = element.text
  assert(label == arg3, "Fuel gauge label is: " + label + ", expected " + arg3)
end
