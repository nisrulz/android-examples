package nisrulz.github.sample.usingkotlin

/*
  If a non-abstract class does not declare any constructors (primary or secondary), it will have a
  generated primary constructor with no arguments. The visibility of the constructor will be public.
  If you do not want your class to have a public constructor, you need to declare an empty primary
  constructor with non-default visibility:
 */
class UtilityClass private constructor() {

}