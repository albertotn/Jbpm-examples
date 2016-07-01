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
 * ends: end events
 
Using signal it's possible to activate other flows and continue with execution

### DataMessage

![Data Message jbpm process](src/main/resources/example/dataMessage/dataMessage.png)

Activities:

 * start: a normal start, activate process when process start
 * script task 1: set a process variable with a value (processVar1="Jbpm")
 * throw event: use Signal to activate the second flow of activities and passing processVar1
 * start event 3: activated after signal is throwned, copy processVar1 to processVar2 
 * script task 2: print to system out processVar2 value
 * ends: end events
 
Using signal it's possible to activate other flows and continue with execution

### CustomDataMessage

![Custom Data Message jbpm process](src/main/resources/example/customDataMessage/CustomDataMessage.png)

Activities:

 * start: a normal start, activate process when process start
 * script task 1: set a process variable using a custom class: CustomMessage (with sender id and the message)
 * throw event: use Signal to activate the second flow of activities and passing processVar1
 * start event 3: activated after signal is throwned, copy processVar1 to processVar2 
 * script task 2: print to system out "Received message Jbpm rocks! from process with id 1"
 * ends: end events
 
Using signal it's possible to activate other flows and continue with execution and in particular comunicate with custom data structure, not only base classes

# License

See LICENSE file
