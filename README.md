<h1 align="center">Welcome to Cache_DB </h1>
<a href="https://www.flaticon.com/free-icons/cache" title="cache icons">Cache icons created by smashingstocks - Flaticon</a>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0-blue.svg?cacheSeconds=2592000" />
  <a href="empty" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
</p>

## Description

> It's a degree proyect where we had to develop a 
>simple cache with a key-value relation using java 

### 🏠 [Homepage]()

## Usage

> To use it, you have to be at the .jar folder: 
> Cache_DB/out/artifacts/Cache_DB_jar/Cache_DB.jar

```sh
java -jar Cache_DB.jar [option] [parameter1] [parameter2] [...]
```

## List of functions


 - get 
    - Gets the value associated with the key passed as argument
    - Parameters: key
    - Returns value associated with the key
 - getAll
      - Gets all the keys stored 
      - returns an array of keys
 - size 
    - gets the amount of keys stored
    - returns the number of keys
 - remove
    - Removes a key and its value.
    - Parameters: key
 - addNew
    - Adds a value to a new key. If the key already exists, 
      it throws an exception.
    - Parameters: key, value
 - put
    - Adds or updates the value associated to a key
    - parameters: key, value
 - exists
    - checks if a key exists
    - returns a boolean
 - getOrDefault
    - Return the value of key passed as argument. Otherwise, 
      returs the default value passed as second argument.
    - Parameters: key, defaultValue


## Example Command

```sh
java -jar Cache_DB addNew testKey HelloWorld
```

## Author

👤 **Juan Toca Berdejo**
