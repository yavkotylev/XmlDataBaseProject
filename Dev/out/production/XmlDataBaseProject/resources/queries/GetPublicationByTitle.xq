let $title := "%s"
let $node := doc('src/resources/xml/dblp.xml')/*/*[./title = $title]
return $node