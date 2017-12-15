var UserItem = React.createClass({
  propTypes: {
    userName: React.PropTypes.string.isRequired,
    email: React.PropTypes.string,
    description: React.PropTypes.string,
  },

  render: function() {
    return (
      React.createElement('div', {className: 'UserItem'},
        React.createElement('div', {className: 'UserItem-userName'}, this.props.userName),
        React.createElement('div', {className: 'UserItem-firstName'}, this.props.firstName),
        React.createElement('div', {className: 'UserItem-lastName'}, this.props.lastName)
      )
    )
  },
});