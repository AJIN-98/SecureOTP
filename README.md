# Secure OTP 

This controller provides endpoints for authorizing, generating and verifying OTP (One-Time Password) for user
authentication.

### Maven Build Commands

To build the project, run the following Maven command:

build : `mvn clean install`
Run : `mvn spring-boot:run -Dserver.port=8089`

## Endpoints

- **URL Format**: `http://localhost:8089/otp/endpoints`

## Postman collection

- `src/main/resources/Postman collection`

### Generate OTP

- **URL**: `/otp/generate`
- **Method**: POST
- **Parameters**:
    - `userId`: User ID for which OTP needs to be generated
- **Description**: Generates a new OTP for the specified user ID and saves it.

### Verify OTP

- **URL**: `/otp/verify`
- **Method**: POST
- **Parameters**:
    - `userId`: User ID for which OTP needs to be verified
    - `otp`: OTP to be verified
- **Description**: Verifies the OTP provided by the user for the specified user ID.

### Authorize User

- **URL**: `/otp/authorize`
- **Method**: POST
- **Parameters**:
    - `userId`: User ID to be authorized
- **Description**: Authorizes the user based on certain criteria (e.g., admin access).

## Test Data

### OTP Service

- **User ID**: user123, **OTP**: 123456
- **User ID**: user456, **OTP**: 654321

### Authorization Service

- **Admin**: User ID: user789
- **User**: User ID: user321

## Dependencies

- Java
- Spring Boot
- SecureService (Dependency Injection)
- H2 Database

## Usage

You can use these endpoints in your application for implementing OTP-based user authentication and authorization.

### Database Configuration

This application uses an H2 database. Ensure that the database is properly configured. You can find the database
configuration in the `application.properties` file.



