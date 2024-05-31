### IoC ###

Es un proceso en el que un 
objeto define sus dependencias sin crearlas
Delega el trabajo de construir las 
dependencias a un contenedor de IoC

### DI ###

Es un patron de diseño en el que un objeto recibe las dependencias de otro objeto

### @Bean ###
Es una anotación que se utiliza para indicar que un método de un bean de 
configuración de Spring, produce un bean para ser administrado
por el contenedor de Spring

### @Component ###
Escanea clases en busca de anotaciones con @Component
Las instancia y les inyecta las dependencias especificadas
Inyecto esta clase en el contenedor de Spring

### Estereotipo ###
Spring tiene varios estereotipos como @Component, @Service, @Repository, @Controller
Estos estereotipos son anotaciones que se utilizan para definir un bean


### @Controller/ @Service/ @Repository ###
@Contoller: Se utiliza para marcar una clase como un controlador de Spring

@Service: Se utiliza para marcar una clase en la capa de servicio 