# Pebble View Engine

An Eclipse Krazo extension for the [Pebble Template Engine][pebble].

Pebble extension can be configured either by setting system properties or by creating a configuration file named "pebble.properties" on the project's classpath. System properties have higher priority and will override values set in the properties file.

Available properties:
    
        org.eclipse.krazo.ext.pebble.autoEscaping     // true or false
        org.eclipse.krazo.ext.pebble.cacheActive      // true or false
        org.eclipse.krazo.ext.pebble.escapingStrategy // fully qualified class name
        org.eclipse.krazo.ext.pebble.defaultLocale    // e.q. de 
        org.eclipse.krazo.ext.pebble.newLineTrimming  // true or false
        org.eclipse.krazo.ext.pebble.strictVariables  // true or false
        org.eclipse.krazo.ext.pebble.executorService  // comma separated, fully qualified class names
        org.eclipse.krazo.ext.pebble.tagCacheMax      // e.q. 150
        org.eclipse.krazo.ext.pebble.templateCacheMax // e.q. 150


Properties with value equal to empty string will be ignored.   
All the default values are the same as described in Pebble's documentation except one:
    
    loader is forced to ServletLoader as it is recommended for application server usage

 [pebble]: http://www.mitchellbosecke.com/pebble/home
