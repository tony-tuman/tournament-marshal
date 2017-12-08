var UserForm = React.createClass({
  propTypes: {
    User: React.PropTypes.object.isRequired,
    onChange: React.PropTypes.func.isRequired,
  },

  render: function() {
    return (
      React.createElement('form', {className: 'UserForm'},
        React.createElement('input', {
          type: 'text',
          placeholder: 'Name (required)',
          value: this.props.User.userName,
          onChange: function(e) {
              onChange(Object.assign({}, oldUser, {userName: e.target.value}));
          },
        }),
        React.createElement('input', {
          type: 'email',
          placeholder: 'Email',
          value: this.props.User.email,
          onChange: function(e) {
            onChange(Object.assign({}, oldUser, {email: e.target.value}));
          },
        }),
        React.createElement('textarea', {
          placeholder: 'Description',
          value: this.props.User.description,
          onChange: function(e) {
            onChange(Object.assign({}, oldUser, {description: e.target.value}));
          },
        }),
        React.createElement('button', {type: 'submit'}, "Add User")
      )
    )
  },
});