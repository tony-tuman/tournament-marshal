class ForgotPassword extends React.Component {
    constructor (props) {
        super(props);
    }

    render() {
        return (
            React.createElement('div', {className: 'standardStyle'},
              React.createElement('div', {className: 'userForgottenDiv'},
                React.createElement('input', {type: 'text', placeholder: 'User name', name: 'userName'}),
                React.createElement('br'),
                React.createElement('input', {type: 'button', value: "Send password"})
              )
            )
        );
    }
}