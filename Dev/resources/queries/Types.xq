let $values := doc("dblp-2019-12-01")/*/*/name()

for $value in distinct-values($values)
  let $count := count($values[. eq $value])
  return <result><type>{$value}</type><count>{$count}</count></result>