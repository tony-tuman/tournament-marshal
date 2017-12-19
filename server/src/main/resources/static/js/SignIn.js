class SignIn extends React.Component {

    constructor (props) {
        super(props);
    }

    render() {
        return (
          React.createElement('div', {className: 'standardStyle'},
            React.createElement('h2', {}, 'Sign in to Tournament Marshal'),
            React.createElement('input', {type: 'text', placeholder: 'User Name (required)', name: 'username'}),
            React.createElement('input', {type: 'password', placeholder: 'Password (required)', name: 'password'}),
            React.createElement('input', {type: 'submit', className: 'submitButton', value:'Log in'}),
            React.createElement('br'),
            React.createElement('a', {href:"/forgot-username"},'Forgot user name?'),
            React.createElement('br'),
            React.createElement('a', {href:"/forgot-password"},'Forgot password?')
          )
        );
    }

}

