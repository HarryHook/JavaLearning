grammar Hello;  //Definea grammar called Hello
r :'hello' ID;  //match key word hello followed by an identifier
ID : [a-z]+;    //match lower-case identifiers
WS : [\t\r\n ]+->skip;  //skip spaces,tabs,newlines,\r(Windows)