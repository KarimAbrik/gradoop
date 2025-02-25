[![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://img.shields.io/badge/Maven_Central-0.6.0-blue.svg?label=Maven%20Central)](http://search.maven.org/#search%7Cga%7C1%7Cgradoop)
[![Build Status](https://github.com/dbs-leipzig/gradoop/workflows/Java%20CI/badge.svg)](https://github.com/dbs-leipzig/gradoop/actions?workflow=Java+CI)
[![Code Quality: Java](https://img.shields.io/lgtm/grade/java/g/dbs-leipzig/gradoop.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/dbs-leipzig/gradoop/context:java)
[![Total Alerts](https://img.shields.io/lgtm/alerts/g/dbs-leipzig/gradoop.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/dbs-leipzig/gradoop/alerts)

## Gradoop: Distributed Graph Analytics on Hadoop

[Gradoop](http://www.gradoop.com) is an open source (ALv2) research framework for scalable 
graph analytics built on top of [Apache Flink](http://flink.apache.org/). It offers a graph data model which 
extends the widespread [property graph model](https://github.com/tinkerpop/blueprints/wiki/Property-Graph-Model) 
by the concept of logical graphs and further provides operators that can be applied 
on single logical graphs and collections of logical graphs. The combination of these 
operators allows the flexible, declarative definition of graph analytical workflows.
Gradoop can be easily integrated in a workflow which already uses Flink&reg; operators
and Flink&reg; libraries (i.e. Gelly, ML and Table).

Gradoop is **work in progress** which means APIs may change. It is currently used
as a proof of concept implementation and far from production ready.

The project's documentation can be found in our [Wiki](https://github.com/dbs-leipzig/gradoop/wiki). 
The Wiki also contains a [tutorial](https://github.com/dbs-leipzig/gradoop/wiki/Getting-started) to 
help getting started using Gradoop.

##### Further Information (articles and talks)

* [Distributed temporal graph analytics with GRADOOP, VLDB Journal, May 2021](https://dbs.uni-leipzig.de/file/Rost2021_Article_DistributedTemporalGraphAnalyt.pdf)
* [Exploration and Analysis of Temporal Property Graphs, EDBT Demo, March 2021](https://dbs.uni-leipzig.de/file/EDBT_DEMO_Rost_2021_published.pdf)
* [Graph Sampling with Distributed In-Memory Dataflow Systems, BTW, March 2021](https://dbs.uni-leipzig.de/file/A3-21.pdf)
* [Evolution Analysis of Large Graphs with Gradoop, ECML PKDD LEG Workshop, September 2019](https://dbs.uni-leipzig.de/file/LEGECML-PKDD_2019_paper_9.pdf)
* [Gradoop @Gridka Keynote Distributed Graph Analytics, August 2019](https://indico.scc.kit.edu/event/460/contributions/5772/attachments/2873/4171/gradoop_gridka19.pdf)
* [Temporal Graph Analysis using Gradoop, BTW 2019-Workshopband, March 2019](https://dl.gi.de/bitstream/handle/20.500.12116/21797/C2-1.pdf)
* [Declarative and distributed graph analytics with GRADOOP, VLDB Demo, August 2018](http://www.vldb.org/pvldb/vol11/p2006-junghanns.pdf)
* [Cypher-based Graph Pattern Matching in Apache Flink, FlinkForward, September 2017](https://youtu.be/dZ8_v_P1j98)
* [Cypher-based Graph Pattern Matching in GRADOOP, SIGMOD GRADES Workshop, May 2017](https://dbs.uni-leipzig.de/file/GRADES17_Cypher_in_Gradoop.pdf)
* [DIMSpan - Transactional Frequent Subgraph Mining with Distributed In-Memory Dataflow Systems, arXiv, March 2017](https://arxiv.org/pdf/1703.01910.pdf)
* [Distributed Grouping of Property Graphs with GRADOOP, BTW Conf., March 2017](http://dbs.uni-leipzig.de/file/BTW17_Grouping_Research.pdf)
* [Graph Mining for Complex Data Analytics, ICDM Demo, December 2016](http://dbs.uni-leipzig.de/file/Graph_Mining_for_Complex_Data_Analytics.pdf)
* [[german] Graph Mining für Business Intelligence, data2day, October 2016](http://www.slideshare.net/s1ck/gut-vernetzt-skalierbares-graph-mining-fr-business-intelligence)
* [[german] Verteilte Graphanalyse mit Gradoop, JavaSPEKTRUM, October 2016](http://www.sigs-datacom.de/uploads/tx_dmjournals/junghans_petermann_JS_05_16_eeNZ.pdf)
* [Extended Property Graphs with Apache Flink, SIGMOD NDA Workshop, June 2016](http://dbs.uni-leipzig.de/file/EPGM.pdf)
* [Gradoop @Flink/Neo4j Meetup Berlin, March 2016](http://www.slideshare.net/s1ck/gradoop-scalable-graph-analytics-with-apache-flink-flink-neo4j-meetup-berlin)
* [Gradoop @FOSDEM GraphDevroom, January 2016](https://fosdem.org/2016/schedule/event/graph_processing_gradoop_flink_analytics)
* [Gradoop @FlinkForward, September 2015](http://www.slideshare.net/FlinkForward/martin-junghans-gradoop-scalable-graph-analytics-with-apache-flink) ([YouTube](https://youtu.be/WmP9xB_sG2o?list=PLDX4T_cnKjD31JeWR1aMOi9LXPRQ6nyHO))

## Data Model

In the extended property graph model (EPGM), a database consists of multiple 
property graphs which are called logical graphs. These graphs describe
application-specific subsets of vertices and edges, i.e. a vertex or an edge can
be contained in multiple logical graphs. Additionally, not only vertices and edges 
but also logical graphs have a type label and can have different properties.

Data Model elements (logical graphs, vertices and edges) have a unique identifier, 
a single label (e.g. User) and a number of key-value properties (e.g. name = Alice).
There is no schema involved, meaning each element can have an arbitrary number of
properties even if they have the same label.

### Graph operators

The EPGM provides operators for both single logical graphs as well as collections 
of logical graphs; operators may also return single graphs or graph collections. 
An overview and detailed descriptions of the implemented operators can be found in the [Gradoop Wiki](https://github.com/dbs-leipzig/gradoop/wiki/List-of-Operators).

## Setup

### Use gradoop via Maven

* Add one of the following dependencies to your maven project

Stable:

```xml
<dependency>
    <groupId>org.gradoop</groupId>
    <artifactId>gradoop-flink</artifactId>
    <version>0.6.0</version>
</dependency>
```

Latest weekly build (additional repository is required):
```xml
<repositories>
    <repository>
        <id>oss.sonatype.org-snapshot</id>
        <url>http://oss.sonatype.org/content/repositories/snapshots</url>
        <releases><enabled>false</enabled></releases>
        <snapshots><enabled>true</enabled></snapshots>
    </repository>
</repositories>
```

```xml
<dependency>
    <groupId>org.gradoop</groupId>
    <artifactId>gradoop-flink</artifactId>
    <version>0.7.0-SNAPSHOT</version>
</dependency>

```
In any case you also need Apache Flink (version 1.9.3):
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.flink</groupId>
        <artifactId>flink-java</artifactId>
        <version>1.9.3</version>
    </dependency>
    <dependency>
        <groupId>org.apache.flink</groupId>
        <artifactId>flink-clients_2.11</artifactId>
        <version>1.9.3</version>
    </dependency>
</dependencies>
```

### Build gradoop from source

* Gradoop requires Java 8
* Clone Gradoop into your local file system

    > git clone https://github.com/dbs-leipzig/gradoop.git
    
* Build and execute tests

    > cd gradoop
    
    > mvn clean install

* You might want to skip tests for faster builds. Also, some tests fail on Windows due to missing test dependencies

    > mvn clean install -DskipTests

### Windows

* Some operators require the Hadoop winutils

## Gradoop modules

### gradoop-common

The main contents of that module are the EPGM data model and a corresponding POJO 
implementation which is used in Flink&reg;. The persistent representation of the EPGM
is also contained in gradoop-common and together with its mapping to HBase&trade;.

### gradoop-data-integration

Provides functionalities to support graph data integration.
This includes minimal CSV and JSON importers as well as graph transformation operators
(e.g. connect neighbors or conversion of edges to vertices and vice versa).

### gradoop-accumulo

Input and output formats for reading and writing graph collections from [Apache Accumulo&reg;](https://accumulo.apache.org/).

### gradoop-hbase

Input and output formats for reading and writing graph collections from [Apache HBase&trade;](https://hbase.apache.org/).

### gradoop-flink

This module contains reference implementations of the EPGM operators. The 
EPGM is mapped to Flink&reg; DataSets while the operators are implemented
using DataSet transformations. The module also contains implementations of 
general graph algorithms (e.g. Label Propagation, Frequent Subgraph Mining)
adapted to be used with the EPGM model.

### gradoop-temporal

This module contains a reference implementation of the Temporal Property Graph Model (TPGM) and
it's operators used to perform graph analysis with respect to the additional time dimension in real-world graphs.

### gradoop-examples

Contains example pipelines showing use cases for Gradoop. 

*   Graph grouping example (build structural aggregates of property graphs)
*   Social network examples (composition of multiple operators to analyze social networks graphs)
*   Input/Output examples (usage of DataSource and DataSink implementations)

### gradoop-checkstyle

Used to maintain the code style for the whole project.

## Related Repositories

### [Gradoop Tutorial](https://github.com/dbs-leipzig/gradoop-tutorial)

Gradoop Tutorial which has been shown in [BOSS20'](https://boss-workshop.github.io/boss-2020/) Workshop of VLDB 2020 international conference.

### [Gradoop Benchmarks](https://github.com/dbs-leipzig/gradoop-benchmarks)

This repository contains sets of Gradoop operator benchmarks designed to run on a cluster to measure
scalability and speedup of the operators.

### [Gradoop Demo](https://github.com/dbs-leipzig/gradoop_demo)

Demo application to show the functionalities of the grouping and query operator in an interactive web UI.


### [Temporal Graph Explorer](https://github.com/dbs-leipzig/temporal_graph_explorer)

Gradoop Temporal Graph Explorer Demo which showcases some operators of the Temporal Property Graph Model.

### [Gradoop GDL](https://github.com/dbs-leipzig/gdl)

This repository contains the definition of our Temporal Graph Definition Language (Temporal-GDL).

### Version History

See the [Changelog](https://github.com/dbs-leipzig/gradoop/wiki/Changelog) at the Wiki pages. 

### Disclaimer

Apache&reg;, Apache Accumulo&reg;, Apache Flink, Flink&reg;, Apache HBase&trade; and 
HBase&trade; are either registered trademarks or trademarks of the Apache Software Foundation 
in the United States and/or other countries.




