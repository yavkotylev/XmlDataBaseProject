let $title := "%s"
return delete node doc("resources/xml/dblp.xml")/*/*[./title = $title]