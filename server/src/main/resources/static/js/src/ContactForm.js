var ContactForm = React.createClass({
  propTypes: {
    contact: React.PropTypes.object.isRequired,
    onChange: React.PropTypes.func.isRequired,
  },

  render: function() {
    return (
      React.createElement('form', {className: 'ContactForm'},
        React.createElement('input', {
          type: 'text',
          placeholder: 'Name (required)',
          value: this.props.contact.name,
          onChange: function(e) {
              onChange(Object.assign({}, oldContact, {name: e.target.value}));
          },
        }),
        React.createElement('input', {
          type: 'email',
          placeholder: 'Email',
          value: this.props.contact.email,
          onChange: function(e) {
            onChange(Object.assign({}, oldContact, {email: e.target.value}));
          },
        }),
        React.createElement('textarea', {
          placeholder: 'Description',
          value: this.props.contact.description,
          onChange: function(e) {
            onChange(Object.assign({}, oldContact, {description: e.target.value}));
          },
        }),
        React.createElement('button', {type: 'submit'}, "Add Contact")
      )
    )
  },
});