# Scala CSV Workshop

A programming workshop exploring functional programming design patterns
via the exciting real-world problem domain of CSV parsing.

Workshop Copyright 2016 [Dave Gurnell][dave-gurnell] of [Underscore][underscore].
Licensed [CC-BY-NC-SA 4.0][license].

Cities and countries sample data Copyright [Statistics Finland][statistics-finland].

## Workshop Structure

The workshop will be split into three stages:

1. Initial discussion (10 minutes).

   Discuss the problem as a group and split everyone into teams.

1. Development (80 minutes)

   Each team writes a library to satisfy the design brief
   (or get as far as they can in the time).

2. Presentation (30 minutes)

   Each team presents its design decisions; we discuss different approaches.

## Design Brief

As part of a strategic push towards cutting edge technology,
our CTO at Acme Widgets Pty Ltd has recommended that
we migrate all of our existing and new IT infrastructure to
an exciting new data interchange format called "Comma Separated Values" (aka "CSV").

Your team has been tasked with building a library to read CSV files.
Other teams will use your reader to import CSV data
into their Scala applications as well-typed objects.

Feel free to use any general purpose functional programming libraries in your solution.
However, do not use any libraries with CSV-specific functionality other than those provided.

The important characteristics of CSV are:

- Files have a single header row and zero or more body rows.
- Each body row represents a record; each cell a field in that record.
- The header row determines which columns represent which fields.
- Fields have three types: string, integer, and real.

### Minimum Viable Product

An MVP CSV reader should read a CSV file as a list of records of a type `A`.
Users of the library can specify the type `A` and how it maps to the CSV data.
The reader should interpret the CSV data, try to parse it appropriately,
and report errors wherever it is unable to do so.

You have been given a low-level CSV parser to get you started.
This turns raw CSV data into a `List[List[String]]`
ready for transformation by your library.
See `LowLevelParser.scala` and `LowLevelParserSpec.scala` for examples.

You have also been given two example CSV files for testing purposes:
`src/main/resources/cities.csv` and `src/main/resources/countries.csv`.
You can load these using the `parseCsvResource` method in `LowLevelParser`.

### Non-Functional Requirements

A basic CSV reader library will:

- Allow users to specify the format of the CSV file in a simple, declarative syntax.
- Be robust and thread-safe.
- Be easy to maintain and extend (for example by adding support for new data types).
- Provide error messages when it encounters invalid data.

A strong CSV reader library will also:

- Be robust to changes in column order.
- Be robust to the presence of extraneous columns that the user isn't interested in.
- Report *all* errors it encounters during parsing.
- Continue to parse valid data in the CSV file even after it has encountered errors.

[dave-gurnell]: http://davegurnell.com
[underscore]: http://underscore.io
[license]: http://creativecommons.org/licenses/by-nc-sa/4.0
[statistics-finland]: http://www.stat.fi/worldinfigures
