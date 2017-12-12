class ForgotUsername extends React.Component {
    constructor (props) {
        super(props);
    }

    render() {
        return (
            React.createElement('div', {className: 'standardStyle'},
              React.createElement('div', {className: 'userForgottenDiv'},
                React.createElement('input', {type: 'text', placeholder: 'Email address', name: 'emailAddress'}),
                React.createElement('br'),
                React.createElement('input', {type: 'button', value: "Send user name"})
              )
          )
        );
    }
}