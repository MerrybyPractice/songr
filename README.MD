# Songr 

## Album Routes 
    
    - Create Album: 
        /Album/create 
        On this route, you can pass in the information necessary for an album and this route will save it to the database.
         
    - Update Album: 
        /Album/update/{album id} 
        This route will find the specified album and update it with the new information. 
        
    - Get Albums: 
        /Album/All
        This route displays all stored albums. 
    
    - Get Album: 
        /Album/album/{album id}
        This route will display the album stored at the specified id. 
        
    - Delete Album 
        /Album/delete/{album id}
        This route will delete the album stored at the specified id. 

## Test Routes 
    
    - Hello World: 
        To access the HelloWorld route, ensure your machine is running the Songr application on local host 8080. Once you 
        have verified this, visit LocalHost:8080/hello/. If everything is running properly, you should see "Hello World." 
        displayed in your browser. If you do not, check your connection. 
    
    - Capatalize: 
        To access the UpperCase route, ensure your machine is running the Songr application on local host 8080. Once you 
        have verified this, visit LocalHost:8080/capitalize/{wordYouWouldLikeToCapitalizeHere}. If everything is running 
        properly, you should see the word you provided displayed in all caps in your browser. If you do not, check your 
        connection. 