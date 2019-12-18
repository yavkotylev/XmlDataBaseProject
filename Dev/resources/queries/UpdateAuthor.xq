let $oldAuthor := "%s"
let $newAuthor := "%s"
let $title := "%s"
let $node := doc("dblp.xml")/*/*[./title = $title and ./author = $oldAuthor]
let $n := $node/author[./text() = $oldAuthor]
return replace value of node $n with $newAuthor