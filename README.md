# Student API

**Important!!!**
- Inside your **StudentRepository** class (class annotated with `@Repository`), there is a **`public void clear()`** method. It is implementing clearing all data from the repository.
  This clear method is needed for the tests, so do not modify it. 
## Description

Create a *REST API* for a site where a shool can store data about which student has which type of scool books.

Create a **three tier** architecture spring boot app. The app should use h2 and jdbc for data storage (pom, application.properties, schema.sql already prepared for that).
An example for student json:
```json
{
  "id": "abcf",
  "name": "test name",
  "hasHistoryBook": true,
  "hasEnglishBook": true,
  "hasMathBook": true
}
```

Try to make pass as many integration tests as possible, but don't modify the tests!

A student object has:

- String id;
- String name;
- Boolean hasHistoryBook;
- Boolean hasEnglishBook;
- Boolean hasMathBook;

## API endpoints

### Student:

| HTTP method | path                                                                           | description                                                                                        |
|-------------|--------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| GET         | `/student`                                                                     | return with a json made from a list of all student objects. return empty list if no students found |
| POST        | `/student`                                                                     | post a new student, the student is sent in the request body as json                                |
| GET         | `/student/{id}`                                                                | returns with a json made from the student with the given id                                        |
| PUT         | `/student/{id}?hasHistory=true&hasEnglish=true&hasMath=true` | updates book data for the student with the given id                                                |
| DELETE      | `/student`                                                                     | deletes all students                                                                               |
