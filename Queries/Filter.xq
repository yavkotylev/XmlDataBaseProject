let $author := ""
let $types := ()
let $title := ""
let $from := 1994
let $to := 1994

let $items := (for $item in doc("dblp-2019-12-01")/*/*
where 
  ($item/name() = $types or empty($types)) and
  ($item/author/text()[contains(.,$author)] or $author = "") and
  ($item/title[contains(.,$title)] or $title = "") and
  ($item/year>=$from or $from = 0) and
  ($item/year<=$to or $to = 0)
return $item)

for $item in $items
return $item