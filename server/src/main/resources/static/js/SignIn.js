class SignIn extends React.Component {

    constructor (props) {
        super(props);
    }

    render() {
        return (
          React.createElement('div', {className: 'standardStyle'},
            React.createElement('input', {type: 'text', placeholder: 'User Name (required)', name: 'username'}),
            React.createElement('input', {type: 'password', placeholder: 'Password (required)', name: 'password'}),
            React.createElement('input', {type: 'submit', className: 'submitButton', value:'Log in'}),
            React.createElement('br'),
          )
        );
    }

}

