# AEM 6.4 : Project Setup with Apache Sling Context-Aware Configuration and WCM.IO Configuration Editor

This is an example setup with Apache Sling Context-Aware Configuration in AEM, and also Context-Aware Configuration UI with wcm.io. 

The objective of this project is to explore the capabilities of Apache Sling Context-Aware Configuration enabled in an earlier AEM version (6.2), and showcase project setup for this technology. 

NOTE: The setup by itself forces users to make changes to nodes in the JCR. With wcm.io, an author can make changes to a configuration directly from the site's console. 

Sling Context-Aware configuration blog series written by Jörg Hoh explains the strategy of when this capability should be used, also provides an tutorial on the setup - 
https://cqdump.wordpress.com/sling-context-aware-configuration/ 

#### Learn about Apache Sling Context-Aware Configuration
- https://cqdump.wordpress.com/sling-context-aware-configuration/
- https://sling.apache.org/documentation/bundles/context-aware-configuration/context-aware-configuration.html
- https://www.youtube.com/watch?v=1kQ-fkFkiz0

#### Project Setup
- AEM 6.4 Project (Maven AEM Archetype 15) (https://github.com/Adobe-Marketing-Cloud/aem-project-archetype)

#### Pre Requirements
- JAVA JDK 1.8
- Maven 3+
  
#### How To Run
1. Clone the project.
2. cd to the correct directory.
3. on terminal, run 'mvn clean install -PautoInstallPackage -Padobe-public'

#### Technologies Used
- Sling Context-Aware Config by Apache - https://sling.apache.org/documentation/bundles/context-aware-configuration/context-aware-configuration.html
- Sling Context-Aware Config (Enabled UI editing capabilities) by wcm.io - http://wcm.io/caconfig 

#### Highlights
- Context-Aware Configs can only be created in an OSGI bundle.
- Context-Aware Config's inheritance can only be resolved using JAVA code, so I used a sling model.  
- Context-Aware Configs in /conf must the property "sling:configPropertyInherit == true" to enabled config inheritance.
- Context-Aware Configs in /conf are pages, so when publishing updated configs using wcm.io's ui, the configs are also being published. 

## Modules

The main parts of the project are:

* core: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* ui.apps: contains the /apps (and /etc) parts of the project, ie JS&CSS clientlibs, components, templates, runmode specific configs as well as Hobbes-tests
* ui.content: contains sample content using the components from the ui.apps

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with  

    mvn clean install -PautoInstallPackage -Padobe-public
    
Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallPackagePublish
    
Or alternatively

    mvn clean install -PautoInstallPackage -Daem.port=4503

Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

## Testing

There are three levels of testing contained in the project:

* unit test in core: this show-cases classic unit testing of the code contained in the bundle. To test, execute:

    mvn clean test

* server-side integration tests: this allows to run unit-like tests in the AEM-environment, ie on the AEM server. To test, execute:

    mvn clean verify -PintegrationTests

* client-side Hobbes.js tests: JavaScript-based browser-side tests that verify browser-side behavior. To test:

    in the browser, open the page in 'Developer mode', open the left panel and switch to the 'Tests' tab and find the generated 'MyName Tests' and run them.


## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html
