# How To Install Sun Java on Mac

You can download the Java Development Kit (JDK) for Java 7 for the supported versions of Mac OS X from this [link](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

Installation is simple per these instructions:

* Download from the usual place on the Oracle web site.
* Mount the DMG.
* Run the installer.

Each version of JVM you install can be found here: `/Library/Java/JavaVirtualMachines`

# How To Install Sun Java on Ubuntu

* * *

You can still install it using apt-get. To install any version, first execute the following commands:

```bash
$ sudo apt-get install python-software-properties
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
```

Then, depending on the version you want to install, execute one of the following commands:

### Oracle JDK 7

* * *

```bash
$ sudo apt-get install oracle-java7-installer
```

## Further Reference
https://www.digitalocean.com/community/tutorials/how-to-install-java-on-ubuntu-with-apt-get
  
