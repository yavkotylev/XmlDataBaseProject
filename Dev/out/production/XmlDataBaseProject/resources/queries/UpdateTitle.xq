let $oldTitle := "%s"
let $newTitle := "%s"
let $node := doc("Dev/src/resources/xml/dblp.xml")/*/*[./title = $oldTitle]
return replace value of node $node/title with $newTitle