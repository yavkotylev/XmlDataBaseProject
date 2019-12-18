let $title := "%s"
let $authors := (%s)
let $year := %s

let $node := doc("src/resources/xml/dblp.xml")/*

let $authorNodes :=
 (for $author in $authors
  return <author>{$author}</author>)
  
let $content := 
   <title>{$title}</title>
    {$authorNodes}
   <year>{$year}</year>

let $publication := (
<article>
   {$content}
</article>
)

return insert node $publication into $node
