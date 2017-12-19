class UserView extends React.Component {
    constructor (props) {
        super (props);
        this.state = {users:'empty'};
    }

    componentWillMount () {
        console.log('component will mount');
    }

    componentDidMount () {
        console.log('component did mount');
        $.ajax({
            url: '/sparseUsers',
            dataType: 'json',
            success: function(data) {
                 this.setState({users: data});
            }.bind(this)
        });
    }

    render() {
        if (this.state.users === 'empty') {
            console.log('Rendering empty users');
            return(
                React.createElement('div', {className: 'UserView'},
                  React.createElement('h1', {className: 'UserView-title'}, "Users")
                )
            )
        } else {
            console.log('Rendering filled users');
            return(
                React.createElement('div', {className: 'UserView'},
                  React.createElement('h1', {className: 'UserView-title'}, "Users"),
                  React.createElement('ul', null,
                    this.state.users.map(function(user){
                      return React.createElement('li', null, user.userName);
                    })
                  )
                )
            )
        }
    }
}
