var UserView = React.createClass({

  render: function() {
    var UserItemElements = getUsers()
      .filter(function(User) { return User.userName })
      .map(function(User) { return React.createElement(UserItem, User) })

    return (
      React.createElement('div', {className: 'UserView'},
        React.createElement('h1', {className: 'UserView-title'}, "Users"),
        React.createElement('ul', {className: 'UserView-list'}, UserItemElements),
      )
    )
  },
});


function updateNewUser(User) {
  setState({ newUser: User });
}

function getUsers() {
    var request = new XMLHttpRequest();
    request.open('GET', '/sparseUsers', false);  // false is asynchronous request.  Need to use a promise instead?
    //https://www.kirupa.com/html5/making_http_requests_js.htm
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.send();
    let myResponse = JSON.parse(request.response);
    return myResponse;
}

/*
 * Model
 */

// The app's complete current state
var state = {};

// Make the given changes to the state and perform any required housekeeping
function setState(changes) {
  Object.assign(state, changes);

  ReactDOM.render(
    React.createElement(UserView, Object.assign({}, state, {
      onNewUserChange: updateNewUser,
    })),
    document.getElementById('main-canvas')
  );
}

// Set initial data
setState({
  Users: getUsers(),
  newUser: {useName: "", email: "", description: ""},
});