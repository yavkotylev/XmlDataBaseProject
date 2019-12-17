let $title := "%s"
let $author := "%s"
let $from := %s
let $to := %s
let $types := (%s)

let $items := (for $item in doc("src/resources/xml/dblp.xml")/*/*
where 
  ($item/name() = $types or empty($types)) and
  ($item/author/text()[contains(.,$author)] or $author = "") and
  ($item/title[contains(.,$title)] or $title = "") and
  ($item/year>=$from or $from = 0) and
  ($item/year<=$to or $to = 0)
return $item
)

return $items