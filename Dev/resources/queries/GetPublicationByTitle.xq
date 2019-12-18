let $title := "%s"
let $node := doc('resources/xml/dblp.xml')/*/*[./title = $title]
return $node