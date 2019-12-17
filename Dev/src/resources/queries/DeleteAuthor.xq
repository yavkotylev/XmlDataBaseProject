let $author := "%s"
let $title := "%s"
let $node := doc("src/resources/xml/dblp.xml")/*/*[./title = $title and ./author = $author]
let $n := $node/author[./text() = $author]
return delete node $n