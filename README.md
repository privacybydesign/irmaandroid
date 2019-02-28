# irmaandroid

This library enables the starting of irma sessions from an android app. Specifically, it implements the handing of of the irma session to the irma_mobile app.

## Usage

First, this library assumes that you have implemented some way of getting a session pointer from you backend systems. For information on how to get this, see the irma documentation and the demosrv sample server implementation. Furhtermore, it is assumed that you have set up some form of url-based scheme to let the irma_mobile app hand control back to your app. For an example on how to implement this using deep links see the IRMAAndroidDemoApp project.

Given these two ingredients, the session can be handed to irma_mobile by calling
```java
import foundation.privacybydesign.irmaandroid.irmaandroid
//...
		irmaandroid.StartIRMA(sessionpointer, returnURI, currentActivity);
```

The third argument, currentActivity, is the activity that the library uses to call StartActivity on to start irma_mobile. This method throws `foundation.privacybydesign.irmaandroid.InvalidRequest` when presented with an malformed sessionpointer.

## Example app

For an example of a complete flow, including a backend server, take a look at the demoserver and IRMAndroidDemoApp projects in the [irma-examples](https://github.com/privacybydesign/irma-examples).
