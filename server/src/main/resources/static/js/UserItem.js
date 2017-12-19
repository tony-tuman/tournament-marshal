class UserItem extends React.Component {
  render() {
    return (
      React.createElement('div', {className: 'UserItem'},
        React.createElement('div', {className: 'UserItem-userName'}, this.props.userName),
        React.createElement('div', {className: 'UserItem-firstName'}, this.props.firstName),
        React.createElement('div', {className: 'UserItem-lastName'}, this.props.lastName)
      )
    )
  }
}