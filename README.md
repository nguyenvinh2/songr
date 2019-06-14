# Basic Spring Web Application

## Introduction

This is an intro web application using Spring Boot

The application contains three main routes with associated controllers:

        /
            This is the home page that will return a collection  of albums.
            initially seeded with 2 random albums.
            can create new albums. Requires the following inputs:
            
                    Title
                    Artist
                    Songs
                    Duration
                    Image
        /song/{id} (GET)
        
            The / route will have links to each album with its associated songs.
            The {id} is associated with the album id.
            
            The songs utilize a CRUD model:
            
            /song/{id}/add (POST)
            
            Adds a new song to the associated album
            
            /song/{id}/edit (POST)
            
            Edits the information about the song
            
            /song/{id}/delete
            
            Deletes the song from the album
            
        /hello
        
            Returns "Hello World" in the web browser
        
        /capitalize/{Path Variable}
        
            Returns all uppercase versions of any string in the Path Variable
            Ex: hello -> HELLO
            
        /reverse?sentence={sentence}
        
            Takes in a sentence and reverse the order.
            Ex: Hello how are you - > you are how Hello
            
## Instructions
        
        Ensure you have Gradle installed on your machine.
        Clone this repo.
        Navigate to the root directory of the repo.
        use "gradle bootRun" to start the application and navigate to the correct URL mentioned above.
        use "gradle test" to test the application
        
        OR
        
        Open project with IntelliJ.
        Navigate to the SongrApplication java file in the src directory and run the file.
        
        After running

## Notes
    
    You must create a Postgres database beforehand.

    The application.properties uses environmental variables.
    
    Under Edit Configuration in your application, set the following environmental variables:
    DATABASE_URL: the url to the database you created so Spring can create the required tables
    PSQL_USERNAME: username for Postgres
    PSQL_PASSWORD: postgres password
    
    Note: using environment variables in IntelliJ will only work if the application
    is started in IntelliJ
    
    Gradle commands will not be able see IntelliJ env variables so the variables must
    directly be injected into the application.properties file.
    Upon running the application, the tables will be established.
        
        
        
        