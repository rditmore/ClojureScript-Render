
# Intro

This ClojureScript example is taken from the an 
written by Mark McGranaghan in the Nov/Dec 2011 IEEE magazine.

A pdf of the document is available
[here](http://steve.vinoski.net/pdf/IC-ClojureScript.pdf) and is well
worth the time to read.  Mark make the following observation in the
article

> These examples also highlight a subtle but important aspect of
> ClojureScript: it's a semantics-altering compiler as opposed to a
> syntactic layer above JavaScript. CoffeeScript and several other
> LISP-to-JavaScript compilers take the latter approach, but
> ClojureScripts's semantics-level approach is ultimately what lets it
> bring the robustness of functional programming to the browser.

and this keen insight is an example of what makes the article very
informative.

The example in this repo is taken from the section *An Example
ClojureScript Application* with the following modifications

 * I built the clojurescript in the development mode, not the
   optimized mode, for easier debugging.
   
 * I had to add a charset option to the html file for browsers on my
   mac to work correctly.  (Not sure if this is a setting thing or a
   change to maybe the clojure script reader since the article was
   published.)

# Getting started

To compile 

> /path/to/cljsc src > demo.js



