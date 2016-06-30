# Jbpm examples

A set of example using [Jbpm](http://www.jbpm.org/) an open source business process management project from [Jboss community](http://www.jboss.org/). Jbpm implemens JBPMN 2.0 standard.

## Usage

In order to use this project you must install:

* java 8
* maven 3.3.3 
* a development Ide ( I'm using eclipse )

To compile and run test just run: *mvn test*

## Examples

### Hello World

![Hello World jbpm process](src/main/resources/example/helloworld/HelloWorld.png)

Activities:

 * start
 * a script task that output "Hello World" on system out
 * end

### ProcessId 

![Print process Id jbpm process](src/main/resources/example/processId/processId.png)

Activities:

 * start
 * script task: output "Hi, my process id is 1" on system out. *Note that is possibile in script task get current process instance information*
 * end

### CreateInstances

![Create Instances jbpm process](src/main/resources/example/createInstances/CreateInstances.png)

Activities:

 * start
 * script task: print process Id information
 * end
 
Using jbpm api it's possible to create more instances for the same process definition. In this test, we will create 10 process instance from this process definition

### SignalProcess

![Signal Process jbpm process](src/main/resources/example/signalProcess/signalProcess.png)

Activities:

 * start: a normal start, activate process when process start
 * throw event: use Signal to activate the second flow of activities
 * start event 2: activated after signal is throwned 
 * script task: print "Hello after catch" on system out
 * end: even events
 
Using signal it's possible to activate other flows and continue with execution


# License

See LICENSE file
