# Documentación de Service Security

## Person

### ** POST => http://localhost:9000/service-security/v1/api/person **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T20:40:55.434Z",
        "updatedAt": "2024-02-16T20:40:55.434Z",
        "deletedAt": "2024-02-16T20:40:55.434Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "phone": "string",
        "dateOfBirth": "2024-02-16",
        "gender": "string",
        "address": "string"
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "firstName": "Jesús",
        "lastName": "González",
        "email": "jesus@gmailcom",
        "phone": "3123123",
        "dateOfBirth": "1992-02-16",
        "gender": "M",
        "address": "Calle 56"
    }
```

### ** PUT => http://localhost:9000/service-security/v1/api/person/1 **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T20:40:55.434Z",
        "updatedAt": "2024-02-16T20:40:55.434Z",
        "deletedAt": "2024-02-16T20:40:55.434Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "firstName": "string",
        "lastName": "string",
        "email": "string",
        "phone": "string",
        "dateOfBirth": "2024-02-16",
        "gender": "string",
        "address": "string"
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "firstName": "Jesús Ariel",
        "lastName": "González Bonilla",
        "email": "jesus@gmailcom",
        "phone": "3123123",
        "dateOfBirth": "1992-02-16",
        "gender": "M",
        "address": "Calle 56"
    }
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/person **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/person/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/person/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# *******************************************************************************
## User

### ** POST => http://localhost:9000/service-security/v1/api/user **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T21:59:33.524Z",
        "updatedAt": "2024-02-16T21:59:33.524Z",
        "deletedAt": "2024-02-16T21:59:33.524Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "username": "string",
        "password": "string",
        "person": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T21:59:33.524Z",
            "updatedAt": "2024-02-16T21:59:33.524Z",
            "deletedAt": "2024-02-16T21:59:33.524Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "firstName": "string",
            "lastName": "string",
            "email": "string",
            "phone": "string",
            "dateOfBirth": "2024-02-16",
            "gender": "string",
            "address": "string"
        }
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "username": "Dannnor",
        "password": "2220badjnnn",
        "person": {
            "id": 0
        }
    }
```

### ** PUT => http://localhost:9000/service-security/v1/api/user/1 **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T22:07:50.390Z",
        "updatedAt": "2024-02-16T22:07:50.390Z",
        "deletedAt": "2024-02-16T22:07:50.390Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "username": "string",
        "password": "string",
        "person": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:07:50.390Z",
            "updatedAt": "2024-02-16T22:07:50.390Z",
            "deletedAt": "2024-02-16T22:07:50.390Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "firstName": "string",
            "lastName": "string",
            "email": "string",
            "phone": "string",
            "dateOfBirth": "2024-02-16",
            "gender": "string",
            "address": "string"
        }
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "username": "Danor",
        "password": "3307nnnabdj",
        "person": {
            "id": 0
        }
    }
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/user **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/user/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/user/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ****************************************************************************
## Role

### ** POST => http://localhost:9000/service-security/v1/api/role **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T22:18:28.125Z",
        "updatedAt": "2024-02-16T22:18:28.125Z",
        "deletedAt": "2024-02-16T22:18:28.125Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "name": "string",
        "description": "string"
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "name": "Administrador",
        "description": "Es una persona con un usuario especial, el cual puede..."
    }
```

### ** PUT => http://localhost:9000/service-security/v1/api/role/1 **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T22:21:31.202Z",
        "updatedAt": "2024-02-16T22:21:31.202Z",
        "deletedAt": "2024-02-16T22:21:31.202Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "name": "string",
        "description": "string"
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "name": "Invitado",
        "description": "Se limita a solo visualizar la interfaz de la aplicación..."
    }
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/role **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/role/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/role/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# **************************************************************************
##  User y Role

### ** POST => http://localhost:9000/service-security/v1/api/userRole **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T22:30:14.115Z",
        "updatedAt": "2024-02-16T22:30:14.115Z",
        "deletedAt": "2024-02-16T22:30:14.115Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "user": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:30:14.115Z",
            "updatedAt": "2024-02-16T22:30:14.115Z",
            "deletedAt": "2024-02-16T22:30:14.115Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "username": "string",
            "password": "string",
            "person": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:30:14.115Z",
            "updatedAt": "2024-02-16T22:30:14.115Z",
            "deletedAt": "2024-02-16T22:30:14.115Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "firstName": "string",
            "lastName": "string",
            "email": "string",
            "phone": "string",
            "dateOfBirth": "2024-02-16",
            "gender": "string",
            "address": "string"
            }
        },
        "role": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:30:14.115Z",
            "updatedAt": "2024-02-16T22:30:14.115Z",
            "deletedAt": "2024-02-16T22:30:14.115Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "name": "string",
            "description": "string"
        }
}
```

#### **json a enviar**
```json
    {
        "state": true,
        "user": {
            "id": 0,
            "person": {
                "id": 0 
            }
        },
        "role": {
            "id": 0
        }
    }
```

### ** PUT => http://localhost:9000/service-security/v1/api/userRole/1 **

#### **json normal**
```json
    {
        "id": 0,
        "state": true,
        "createdAt": "2024-02-16T22:30:14.115Z",
        "updatedAt": "2024-02-16T22:30:14.115Z",
        "deletedAt": "2024-02-16T22:30:14.115Z",
        "createdBy": 0,
        "updatedBy": 0,
        "deletedBy": 0,
        "user": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:30:14.115Z",
            "updatedAt": "2024-02-16T22:30:14.115Z",
            "deletedAt": "2024-02-16T22:30:14.115Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "username": "string",
            "password": "string",
            "person": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:30:14.115Z",
            "updatedAt": "2024-02-16T22:30:14.115Z",
            "deletedAt": "2024-02-16T22:30:14.115Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "firstName": "string",
            "lastName": "string",
            "email": "string",
            "phone": "string",
            "dateOfBirth": "2024-02-16",
            "gender": "string",
            "address": "string"
            }
        },
        "role": {
            "id": 0,
            "state": true,
            "createdAt": "2024-02-16T22:30:14.115Z",
            "updatedAt": "2024-02-16T22:30:14.115Z",
            "deletedAt": "2024-02-16T22:30:14.115Z",
            "createdBy": 0,
            "updatedBy": 0,
            "deletedBy": 0,
            "name": "string",
            "description": "string"
        }
    }
```

#### **json a enviar**
```json
    {
        "state": true,
        "user": {
            "id": 0,
            "person": {
                "id": 0 
            }
        },
        "role": {
            "id": 0
        }
    }
```

### ** Get (All) => http://localhost:9000/service-security/v1/api/userRole **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Get (Id) => http://localhost:9000/service-security/v1/api/userRole/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

### ** Delete (Id) => http://localhost:9000/service-security/v1/api/userRole/1 **

#### **json normal**
```json
    {
       
    }
```

#### **json a enviar**
```json
    {
      
    }
```

# ********************************************