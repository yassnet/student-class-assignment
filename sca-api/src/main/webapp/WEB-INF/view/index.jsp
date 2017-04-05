<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="main.css">
    <meta charset="UTF-8">
    <title>Students - Classes Assignemnt</title>
                                                         </head>
<body>
<div class="container">
    <h1>Students - Classes Assignemnt</h1>
    <p class="sw-info">Base URL: <span class="sw-info-basePath">/</span>, Version: <span class="sw-info-version">1.0</span></p>
    <p><p>Students - Classes Assignemnt RESTFul Web service.</p>
    <p>See <a href="https://github.com/yassnet/student-class-assignment">Gibhub Project</a> for more information.</p>
    </p>
    
    
    <div id="sw-schemes" class="sw-default-value">
        <span class="sw-default-value-header">Schemes:</span>
        http
    </div>
    
        
        <h2 id="swagger--summary-tags">Summary</h2>
            <h3 id="tag-student" class="swagger-summary-tag">Tag: student</h3>
            
        
            <table class="table table-bordered table-condensed swagger--summary">
                <thead>
                <tr>
                    <th>Operation</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a href="#operation--students-get">GET /students</a></td>
                        <td><p>Get all students</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--students-delete">DELETE /students</a></td>
                        <td><p>Deletes all students</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student-new-post">POST /student/new</a></td>
                        <td><p>Create a new student</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student--id--put">PUT /student/{id}</a></td>
                        <td><p>Update an existing student</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student--id--get">GET /student/{id}</a></td>
                        <td><p>Find student by ID</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student--id--delete">DELETE /student/{id}</a></td>
                        <td><p>Deletes a Student</p>
        </td>
                    </tr>
                </tbody>
            </table>
            <h3 id="tag-class" class="swagger-summary-tag">Tag: class</h3>
            
        
            <table class="table table-bordered table-condensed swagger--summary">
                <thead>
                <tr>
                    <th>Operation</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a href="#operation--classes-get">GET /classes</a></td>
                        <td><p>Get all classes</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--classes-delete">DELETE /classes</a></td>
                        <td><p>Deletes all classes</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class-new-post">POST /class/new</a></td>
                        <td><p>Create a new class</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class--id--put">PUT /class/{id}</a></td>
                        <td><p>Update an existing class</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class--id--get">GET /class/{id}</a></td>
                        <td><p>Find class by ID</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class--id--delete">DELETE /class/{id}</a></td>
                        <td><p>Deletes a Class</p>
        </td>
                    </tr>
                </tbody>
            </table>
            <h3 id="tag-assignment" class="swagger-summary-tag">Tag: assignment</h3>
            
        
            <table class="table table-bordered table-condensed swagger--summary">
                <thead>
                <tr>
                    <th>Operation</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a href="#operation--assignments-get">GET /assignments</a></td>
                        <td><p>Get all assignments</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--assignments-delete">DELETE /assignments</a></td>
                        <td><p>Deletes a assignments</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class--code--students-get">GET /class/{code}/students</a></td>
                        <td><p>Get all students of a class</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student--code--classes-get">GET /student/{code}/classes</a></td>
                        <td><p>Get all classes of a student</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class--code--student--id--put">PUT /class/{code}/student/{id}</a></td>
                        <td><p>Assign a class to student</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--class--code--student--id--delete">DELETE /class/{code}/student/{id}</a></td>
                        <td><p>Deletes a Student of a Class</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student--code--class--id--put">PUT /student/{code}/class/{id}</a></td>
                        <td><p>Assign a student to class</p>
        </td>
                    </tr>
                    <tr>
                        <td><a href="#operation--student--code--class--id--delete">DELETE /student/{code}/class/{id}</a></td>
                        <td><p>Deletes a Class of a Student</p>
        </td>
                    </tr>
                </tbody>
            </table>
        
    
    
    
    <h2>Paths</h2>
    
        
        <span id="path--assignments"></span>
            <div id="operation--assignments-delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes a assignments</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/assignments</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-204">
                                        204 No Content
                                    
                                    </dt>
                                    <dd class="sw-response-204">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--assignments-get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Get all assignments</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/assignments</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--class-new"></span>
            <div id="operation--class-new-post" class="swagger--panel-operation-post panel">
                <div class="panel-heading">
                    <div class="operation-summary">Create a new class</div>
                    <h3 class="panel-title"><span class="operation-name">POST</span> <strong>/class/new</strong></h3>
                        Tags:
                            <a href="#tag-class">class</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                        <section class="sw-request-params">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="sw-param-name"></th>
                                    <th class="sw-param-description"></th>
                                    <th class="sw-param-type"></th>
                                    <th class="sw-param-data-type"></th>
                                    <th class="sw-param-annotation"></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td>
                                                
                                            <td><p>Class object to be added to data base</p>
                                        </td>
                                            <td></td>
                                            <td>
                                        <span class="json-property-type">object</span>
                                        <span class="json-property-range" title="Value limits"></span>
                                        
                                            </td>
                                            <td>
                                                    <span class="json-property-required"></span>
                                            </td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-201">
                                        201 Created
                                    
                                    </dt>
                                    <dd class="sw-response-201">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Created</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--class--code--student--id-"></span>
            <div id="operation--class--code--student--id--delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes a Student of a Class</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/class/{code}/student/{id}</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-204">
                                        204 No Content
                                    
                                    </dt>
                                    <dd class="sw-response-204">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class or Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--class--code--student--id--put" class="swagger--panel-operation-put panel">
                <div class="panel-heading">
                    <div class="operation-summary">Assign a class to student</div>
                    <h3 class="panel-title"><span class="operation-name">PUT</span> <strong>/class/{code}/student/{id}</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class or Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--class--code--students"></span>
            <div id="operation--class--code--students-get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Get all students of a class</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/class/{code}/students</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--class--id-"></span>
            <div id="operation--class--id--delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes a Class</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/class/{id}</strong></h3>
                        Tags:
                            <a href="#tag-class">class</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-204">
                                        204 No Content
                                    
                                    </dt>
                                    <dd class="sw-response-204">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--class--id--get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Find class by ID</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/class/{id}</strong></h3>
                        Tags:
                            <a href="#tag-class">class</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        <p>Returns a class with Id</p>
            
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--class--id--put" class="swagger--panel-operation-put panel">
                <div class="panel-heading">
                    <div class="operation-summary">Update an existing class</div>
                    <h3 class="panel-title"><span class="operation-name">PUT</span> <strong>/class/{id}</strong></h3>
                        Tags:
                            <a href="#tag-class">class</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                        <section class="sw-request-params">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="sw-param-name"></th>
                                    <th class="sw-param-description"></th>
                                    <th class="sw-param-type"></th>
                                    <th class="sw-param-data-type"></th>
                                    <th class="sw-param-annotation"></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td>
                                                
                                            <td><p>Class object to be updated</p>
                                        </td>
                                            <td></td>
                                            <td>
                                        <span class="json-property-type">object</span>
                                        <span class="json-property-range" title="Value limits"></span>
                                        
                                            </td>
                                            <td>
                                                    <span class="json-property-required"></span>
                                            </td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--classes"></span>
            <div id="operation--classes-delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes all classes</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/classes</strong></h3>
                        Tags:
                            <a href="#tag-class">class</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-204">
                                        204 No Content
                                    
                                    </dt>
                                    <dd class="sw-response-204">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--classes-get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Get all classes</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/classes</strong></h3>
                        Tags:
                            <a href="#tag-class">class</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                        <section class="sw-request-params">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="sw-param-name"></th>
                                    <th class="sw-param-description"></th>
                                    <th class="sw-param-type"></th>
                                    <th class="sw-param-data-type"></th>
                                    <th class="sw-param-annotation"></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                                <td><a name="/parameters/query"></a>query</td>
                                            <td>
                                                
                                            <td><p>Find a class with a title, description or using a key (It finds in code, title and description)</p>
                                        </td>
                                            <td></td>
                                            <td>
                                        <span class="json-property-type">object</span>
                                        <span class="json-property-range" title="Value limits"></span>
                                        
                                            </td>
                                            <td>
                                            </td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--student-new"></span>
            <div id="operation--student-new-post" class="swagger--panel-operation-post panel">
                <div class="panel-heading">
                    <div class="operation-summary">Create a new student</div>
                    <h3 class="panel-title"><span class="operation-name">POST</span> <strong>/student/new</strong></h3>
                        Tags:
                            <a href="#tag-student">student</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                        <section class="sw-request-params">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="sw-param-name"></th>
                                    <th class="sw-param-description"></th>
                                    <th class="sw-param-type"></th>
                                    <th class="sw-param-data-type"></th>
                                    <th class="sw-param-annotation"></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td>
                                                
                                            <td><p>Student object to be added to data base</p>
                                        </td>
                                            <td></td>
                                            <td>
                                        <span class="json-property-type">object</span>
                                        <span class="json-property-range" title="Value limits"></span>
                                        
                                            </td>
                                            <td>
                                                    <span class="json-property-required"></span>
                                            </td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-201">
                                        201 Created
                                    
                                    </dt>
                                    <dd class="sw-response-201">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Created</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--student--code--class--id-"></span>
            <div id="operation--student--code--class--id--delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes a Class of a Student</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/student/{code}/class/{id}</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class or Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--student--code--class--id--put" class="swagger--panel-operation-put panel">
                <div class="panel-heading">
                    <div class="operation-summary">Assign a student to class</div>
                    <h3 class="panel-title"><span class="operation-name">PUT</span> <strong>/student/{code}/class/{id}</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Class or Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--student--code--classes"></span>
            <div id="operation--student--code--classes-get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Get all classes of a student</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/student/{code}/classes</strong></h3>
                        Tags:
                            <a href="#tag-assignment">assignment</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--student--id-"></span>
            <div id="operation--student--id--delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes a Student</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/student/{id}</strong></h3>
                        Tags:
                            <a href="#tag-student">student</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-204">
                                        204 No Content
                                    
                                    </dt>
                                    <dd class="sw-response-204">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--student--id--get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Find student by ID</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/student/{id}</strong></h3>
                        Tags:
                            <a href="#tag-student">student</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        <p>Returns a student with Id</p>
            
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--student--id--put" class="swagger--panel-operation-put panel">
                <div class="panel-heading">
                    <div class="operation-summary">Update an existing student</div>
                    <h3 class="panel-title"><span class="operation-name">PUT</span> <strong>/student/{id}</strong></h3>
                        Tags:
                            <a href="#tag-student">student</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                        <section class="sw-request-params">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="sw-param-name"></th>
                                    <th class="sw-param-description"></th>
                                    <th class="sw-param-type"></th>
                                    <th class="sw-param-data-type"></th>
                                    <th class="sw-param-annotation"></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td>
                                                
                                            <td><p>Student object to be updated</p>
                                        </td>
                                            <td></td>
                                            <td>
                                        <span class="json-property-type">object</span>
                                        <span class="json-property-range" title="Value limits"></span>
                                        
                                            </td>
                                            <td>
                                                    <span class="json-property-required"></span>
                                            </td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-404">
                                        404 Not Found
                                    
                                    </dt>
                                    <dd class="sw-response-404">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Student not found</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    
        <span id="path--students"></span>
            <div id="operation--students-delete" class="swagger--panel-operation-delete panel">
                <div class="panel-heading">
                    <div class="operation-summary">Deletes all students</div>
                    <h3 class="panel-title"><span class="operation-name">DELETE</span> <strong>/students</strong></h3>
                        Tags:
                            <a href="#tag-student">student</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                    
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-204">
                                        204 No Content
                                    
                                    </dt>
                                    <dd class="sw-response-204">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>    <div id="operation--students-get" class="swagger--panel-operation-get panel">
                <div class="panel-heading">
                    <div class="operation-summary">Get all students</div>
                    <h3 class="panel-title"><span class="operation-name">GET</span> <strong>/students</strong></h3>
                        Tags:
                            <a href="#tag-student">student</a>
                </div>
                <div class="panel-body">
                    <section class="sw-operation-description">
                        
                    </section>
                        
                            <section class="sw-request-body">
                                
                                    <p><span class="label label-default">application/json</span> 
                        </p>
                            </section>        
                        <section class="sw-request-params">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="sw-param-name"></th>
                                    <th class="sw-param-description"></th>
                                    <th class="sw-param-type"></th>
                                    <th class="sw-param-data-type"></th>
                                    <th class="sw-param-annotation"></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                                <td><a name="/parameters/query"></a>query</td>
                                            <td>
                                                
                                            <td><p>Find a student with a first name, last name or full name</p>
                                        </td>
                                            <td></td>
                                            <td>
                                        <span class="json-property-type">object</span>
                                        <span class="json-property-range" title="Value limits"></span>
                                        
                                            </td>
                                            <td>
                                            </td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    
                        <section class="sw-responses">
                                <p><span class="label label-default">application/json</span> 
                    </p>
                    
                            <dl>
                                    <dt class="sw-response-200">
                                        200 OK
                                    
                                    </dt>
                                    <dd class="sw-response-200">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>OK</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                                    <dt class="sw-response-405">
                                        405 Method Not Allowed
                                    
                                    </dt>
                                    <dd class="sw-response-405">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p>Request method not supported</p>
                                            
                                                </div>
                                            </div>
                                            <div class="row">
                                                
                                                <div class="col-md-6 sw-response-model">
                                            </div>
                                            
                                            </div>                </dd>
                            </dl>
                        </section>
                </div>
            </div>
     
    
                       
        <h2>Schema definitions</h2>
    
            
                <div id="definition-Class" class="panel panel-definition">
                        <div class="panel-heading">
                                <h3 class="panel-title"><a name="/definitions/Class"></a>Class:
                                    <span class="json-property-type">
                <span class="json-property-type">object</span>
                <span class="json-property-range" title="Value limits"></span>
                
                </span>
                                </h3>
                        </div>
                    <div class="panel-body">
                            
                                    <section class="json-schema-properties">
                                        <dl>
                                                <dt data-property-name="code">
                                                    <span class="json-property-name">code:</span>
                                                    
                                                    <span class="json-property-type">string</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                        <span class="json-property-required"></span>
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                                <dt data-property-name="title">
                                                    <span class="json-property-name">title:</span>
                                                    
                                                    <span class="json-property-type">string</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                                <dt data-property-name="description">
                                                    <span class="json-property-name">description:</span>
                                                    
                                                    <span class="json-property-type">string</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                        </dl>
                                    </section>
                    </div>
                </div>        
                <div id="definition-Student" class="panel panel-definition">
                        <div class="panel-heading">
                                <h3 class="panel-title"><a name="/definitions/Student"></a>Student:
                                    <span class="json-property-type">
                <span class="json-property-type">object</span>
                <span class="json-property-range" title="Value limits"></span>
                
                </span>
                                </h3>
                        </div>
                    <div class="panel-body">
                            
                                    <section class="json-schema-properties">
                                        <dl>
                                                <dt data-property-name="id">
                                                    <span class="json-property-name">id:</span>
                                                    
                                                    <span class="json-property-type">integer</span>    <span class="json-property-format">(int64)</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                                <dt data-property-name="firstName">
                                                    <span class="json-property-name">firstName:</span>
                                                    
                                                    <span class="json-property-type">string</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                        <span class="json-property-required"></span>
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                                <dt data-property-name="lastName">
                                                    <span class="json-property-name">lastName:</span>
                                                    
                                                    <span class="json-property-type">string</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                        <span class="json-property-required"></span>
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                        </dl>
                                    </section>
                    </div>
                </div>        
                <div id="definition-StudentClass" class="panel panel-definition">
                        <div class="panel-heading">
                                <h3 class="panel-title"><a name="/definitions/StudentClass"></a>StudentClass:
                                    <span class="json-property-type">
                <span class="json-property-type">object</span>
                <span class="json-property-range" title="Value limits"></span>
                
                </span>
                                </h3>
                        </div>
                    <div class="panel-body">
                            
                                    <section class="json-schema-properties">
                                        <dl>
                                                <dt data-property-name="student">
                                                    <span class="json-property-name">student:</span>
                                                    
                                                    <span class="json-property-type">object</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                        <span class="json-property-required"></span>
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                                <dt data-property-name="class">
                                                    <span class="json-property-name">class:</span>
                                                    
                                                    <span class="json-property-type">object</span>
                                                    <span class="json-property-range" title="Value limits"></span>
                                                    
                                                        <span class="json-property-required"></span>
                                                </dt>
                                                <dd>
                                                    
                                                    <div class="json-inner-schema">
                                                        
                                                    </div>
                                                </dd>
                                        </dl>
                                    </section>
                    </div>
                </div>
</div>
<script src="bundle.js" type="application/javascript"></script>
</body>
</html>
