<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Learn Spring | FreeMarker Template Engine</title>
</head>
<body>

<#list projects as project>
    <h1>${project.name}</h1>

    Tasks:
    <ol>
        <#list project.tasks as task>
            <li>${task.name} : ${task.description}</li>
        </#list>
    </ol>
</#list>
</body>
</html>