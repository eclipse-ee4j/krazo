# Pebble View Engine

An Eclipse Krazo extension for the [Pebble Template Engine][pebble].

Pebble extension can be configured either by setting system properties or by creating a configuration file named `pebble.properties` on the project's classpath. System properties have higher priority and will override values set in the properties file.

## Available properties
```properties
org.eclipse.krazo.ext.pebble.autoEscaping     # true or false
org.eclipse.krazo.ext.pebble.cacheActive      # true or false
org.eclipse.krazo.ext.pebble.escapingStrategy # fully qualified class name
org.eclipse.krazo.ext.pebble.defaultLocale    # e.q. de 
org.eclipse.krazo.ext.pebble.newLineTrimming  # true or false
org.eclipse.krazo.ext.pebble.strictVariables  # true or false
org.eclipse.krazo.ext.pebble.executorService  # comma separated, fully qualified class names
org.eclipse.krazo.ext.pebble.tagCacheMax      # e.q. 150
org.eclipse.krazo.ext.pebble.templateCacheMax # e.q. 150
org.eclipse.krazo.ext.pebble.extension        # comma separated, fully qualified class names
```

Properties with value equal to empty string will be ignored.
All the default values are the same as described in Pebble's documentation except one:

`loader` is forced to ServletLoader as it is recommended for application server usage.

## Providing custom `PebbleEngine`
If you would like to completely override the default `PebbleEngineProducer` you can make use of the following code sample:
```java
public class CustomPebbleEngineProducer extends PebbleEngineProducer {

    @Context
    ServletContext servletContext;

    @Override
    @Specializes
    @Produces
    @ViewEngineConfig
    public PebbleEngine pebbleEngine() {
        return new PebbleEngine.Builder()
                .loader(new ServletLoader(servletContext))
                //.autoEscaping(...)
                //.addEscapingStrategy(...)
                //...
                .build();
    }

}
```

 [pebble]: https://pebbletemplates.io/
