# spring-flux-callstack
Sample project for callstack verification

How to test:

1. Execute in command like: ```gradlew run```
2. Open in web browser http://localhost:8080/g/999
3. Check the callstack

There are a lot of repeated stack entries here.

This web site has fully static configuration, to all routes can be resolved by using [Trie algorithm](https://en.wikipedia.org/wiki/Trie) 
with O(N) complexity, where N=min(matched url length, input url length).

