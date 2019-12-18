let $author := "%s"
let $title := "%s"
let $node := doc("dblp.xml")/*/*[./title = $title]
return insert node <author>{$author}</author> into $node