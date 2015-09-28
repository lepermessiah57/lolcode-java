![http://lolcode-java.googlecode.com/svn/trunk/docs/images/JavaCC_bastet_250.jpg](http://lolcode-java.googlecode.com/svn/trunk/docs/images/JavaCC_bastet_250.jpg)

This is a Java based implementation of the [LOLCODE](http://lolcode.com) language.

### Update ###
**[Martin Fowler plugs LOLcode](http://martinfowler.com/bliki/GroovyOrJRuby.html)**

"The ruby/rails hype has also generated interest in other exotic JVM languages."

_He doesn't mention LOLcode by name, but I think it falls in the 'exotic JVM languages' category_.

The project has a working parser, and a partially functioning interpreter.  The HAI WORLD and COUNT!!1 programs currently can be executed.

```
HAI
CAN HAS STDIO?
VISIBLE "HAI WORLD!"
KTHXBYE
```

```
$ lol test/samples/hello_world.LOL 
HAI WORLD!
```

```
HAI
I HAS A VAR
IM IN YR LOOP
	UP VAR!!1
	VISIBLE VAR
	IZ VAR BIGGER THAN 10? KTHXBYE
IM OUTTA YR LOOP
KTHXBYE
```

```
$ lol test/samples/count\!\!1.LOL
1
2
3
4
5
6
7
8
9
10
11
```

  * Since LOLCODE does not have curly braces and semi colons, I've made line endings significant.
  * White space is generally only required between tokens, and any number of tabs or spaces are allowed.