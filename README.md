# MVP4G2 Examples
To help you understand the framework, Mvp4g2 comes with tutorials and examples. 

To run the examples:

* clone [mvp4g2](https://github.com/mvp4g/mvp4g2) and install it (mvn install).
* clone mvp4g2-examples and run mvn gwt:devmode

Please, keep in mind, mvp4g2 ist a client framework, so all server calls are simulated on the client side and can easily replaced. 

#### Mvp4g2SimpleApplicationUsingElemental2
A simple application based on MVP4g2 and Elemental 2. In this example, the only class used from GWT is the EntryPoint. 

#### Mvp4g2SimpleApplicationUsingElementalo
A simple application similar to the example Mvp4g2SimpleApplicationUsingElemental2, but using [Elemento](https://github.com/hal/elemento) to create the views.

#### Mvp4g2SimpleApplicationUsingElemental2WithoutHistory
A simple application similar to the example Mvp4g2SimpleApplicationUsingElemental2, but withput using history.

#### Mvp4g2SimpleApplicationUsingGWT2
Same example as Mvp4g2SimpleApplicationUsingElemental2, but using GWT widgets.
