class NewUserForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: "",
            fullName: "",
            email: ""
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({[name]: value});
    }

    handleSubmit(event) {
        alert('Submitting your request');
        event.preventDefault();
    }

    render() {
        return (
            <div>
                <br/>
                <h2>Sign up for Tournament Marshal</h2>
                <br/>
                <form onSubmit={this.handleSubmit}>
                        <input name = 'userName' type='text' placeholder='User Name' value={this.state.userName} onChange={this.handleChange} />
                        <input name = 'fullName' type='text' placeholder='Full Name' value={this.state.fullName} onChange={this.handleChange} />
                        <input name = 'email' type='text' placeholder='Email address' value={this.state.email} onChange={this.handleChange} />
                        <PostalAddressItem />
                        <input type="submit" value="Submit"/>
                        <br/>
                        <a href = "/forgot-username">Forgot user name?</a>
                        <br/>
                        <a href = "/forgot-password">Forgot password?</a>
                </form>
            </div>
        )
    }
}