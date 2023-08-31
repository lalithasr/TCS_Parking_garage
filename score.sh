#!/bin/bash

sample_test='
<?xml version="1.0" encoding="UTF-8"?>
<testsuites time="">
    <testsuite name="Application Build" time="">
        <testcase name="testCase1" classname="Build Application" time="">
            <failure message="Unable to build the application" type="AssertionError">
                The application failed to compile
            </failure>            
        </ testcase>
    </testsuite>
</testsuites>
'
mvn clean test
exit_status=$?
if [ $exit_status -eq 1 ]; then
  mkdir -p target/surefire-reports
  touch target/surefire-reports/TEST-com.tcs.natd.springhandson.parkinggarage.ParkingGarageApplicationTests.xml
  echo $sample_test > target/surefire-reports/TEST-com.tcs.natd.springhandson.parkinggarage.ParkingGarageApplicationTests.xml
fi

exit $exit_status
