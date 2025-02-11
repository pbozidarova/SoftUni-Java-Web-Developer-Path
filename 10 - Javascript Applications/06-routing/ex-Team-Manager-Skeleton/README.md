Exercise: Routing </br>
Lab problem for the “JavaScript Applications” course @ SoftUni.</br>
Team Manager</br>
Create a JS application for managing teams. Use Handlebars for rendering, Sammy.js for routing and Kinvey as a backend provider. Structure your work so that it is easy to manage. The example is styled using Bootstrap.
<ol>
<li>	App Structure</li>
<ul>
<li>	Home Page – show relevant info, depending on the status of the user</li>
<li>	Catalog – a list of all registered teams</li>
<li>	About – dummy page that would hold information about the app</li>
<li>	Register User</li>
<li>	Create Team</li>
<li>	Edit Team</li>
<li>	View Team Details – a detailed page that shows all members of the team and management controls</li>
Create a header that is shared across all pages and place links to the relevant sections in it.
</ul>
<li>	CRUD Operations</li>
The app must support user registration, login and logout. Store the user credential in session storage. Once logged in, the user is free to browse all registered teams and join or create a new team. At any point, the user is able to leave the team he is a member of. The user can only join one team at a time. Also when a user creates a team he automatically joins it. He cannnot create a team again unless he leaves the newly created team.
<li>	Entity Structure</li>
A team has a name and a comment that are displayed while browsing. A user has a username. You may create databases and entries as you see fit. A sample collection structure is as follows:
teams {
  name,
  comment
}
<ol>
Add a column teamId to the default users collection, showing which team they have joined currently. When determining whether a person is the owner of a team, look at the property _acl.creator of the team record.
