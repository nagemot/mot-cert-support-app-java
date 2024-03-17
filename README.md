# Ministry of Testing Certificates in Automation Support App
This project is a simple timesheet app with supporting test automation framework

## Running Automation Checks
Automated checks exist for API tests.  This can be executed using mvn clean verify.

Running UI tests
mvn test -Dtest=Logintest

## CI/CD Integration

The project is integrated with GITHUB actions.  The config file can be found at

.github/workflows/build_test_maven.yml



