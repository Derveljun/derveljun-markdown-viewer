<link rel="stylesheet" type="text/css" href="/lib/showdown/showdown.css" >
<script type="text/javascript" src="/lib/showdown/showdown.min.js"/>
<script>
    (function() {
        let converter = new showdown.Converter();
        let html = converter.makeHtml(document.getElementById("rawMarkdown").textContent);
        document.getElementById("markdown").innerHTML = html;
    })();
</script>

<textarea id="rawMarkdown">${markdown}</textarea>
<div id="markdown"></div>