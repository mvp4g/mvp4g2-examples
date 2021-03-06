# MVP4G2 Examples
To help you to understand how the framework works, Mvp4g2 comes with tutorials and examples. 

To run the examples:

* clone mvp4g2-examples
* select an exampl
* run mvn gwt:devmode

Please, keep in mind, mvp4g2 ist a client framework, so all server calls are simulated on the client side and are mocked in this examples. Because of that, there is no need to have a server. Also, mvp4g2 does not force you to use a special widget lib. This is up to you. In this examples we use native Elemental 2 and Elemento, which does not look very nice, but works!

Most of the examples are used to check features of the framework. Except the *Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotation* example , which is well document and a good point to start.

Most of the examples implement only the Entrypoint and no other GWT classes (except the Mvp4g2SimpleApplicationUsingGWT2 example). So, it will be quite easy to migrate these examples to J2CL/GWT 3.

#### Mvp4g2MailApplication
A simple mail application with a master slave layout. Using the multiple presenter feature. GXT GPL is used for layouting. ***In Progress***

#### Mvp4g2SimpleApplicationUsingElemental2
A simple application based on MVP4g2 and Elemental 2. In this example, the only class used from GWT is the EntryPoint. 

#### Mvp4g2SimpleApplicationUsingElementalo
A simple application similar to the example Mvp4g2SimpleApplicationUsingElemental2, but using [Elemento](https://github.com/hal/elemento) to create the views.

#### Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotation
A simple application similar to the example Mvp4g2SimpleApplicationUsingElementalo, but using the new @EventHandler annotation to bind a handler/presetner method to an event instead of using the handler-attribute inside of the @Event-annotation.

#### Mvp4g2SimpleApplicationUsingElemental2WithoutHistory
A simple application similar to the example Mvp4g2SimpleApplicationUsingElemental2, but without using history.

#### Mvp4g2SimpleApplicationUsingGWT2
Same example as Mvp4g2SimpleApplicationUsingElemental2, but using GWT widgets.

#### Mvp4g2SimpleApplicationWithLogin
This example uses Elemento and the @EventHandler feature and shows how to use a filter. It has a login page at start and uses a filter to check wheather the user is logged in or not. By pressing the 'logout'-button, the user is logged out from the applilcation. The next event will be filtered and the user gets redirected to the login page.
